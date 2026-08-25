package ex0825.multiChat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerGUIChatExam {

	List<ClientSkThread> list = Collections.synchronizedList(new ArrayList<ClientSkThread>());

	public ServerGUIChatExam() {
		try (ServerSocket server = new ServerSocket(8002)) {
			while (true) {
				System.out.println("Client 접속 대기중입니다.");
				Socket sk = server.accept();
				ClientSkThread th = new ClientSkThread(sk);
				th.start();
				list.add(th);
				System.out.println(sk.getInetAddress() + "님 접속하셨습니다.");
				System.out.println("현재 접속 인원 : " + list.size() + "명\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자 끝

	/**
	 * 모든 client에게 데이터 전송하는 메소드
	 */
	public void sendMessage(String message) {
		synchronized (list) {
			for (ClientSkThread th : list) {
				th.pw.println(message);
			}
		}
	}
///////////////////////////////////////////////////////////////////////////

	/**
	 * 접속한 클라이언트의 sk를 Thread로 만들어서 관리
	 */
	class ClientSkThread extends Thread {
		Socket sk;
		PrintWriter pw;
		BufferedReader br;
		String nickNama;

		ClientSkThread(Socket sk) {
			this.sk = sk;
			try {
				pw = new PrintWriter(sk.getOutputStream(), true);
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// 클라이언트가 보내온 내용을 읽어서 접속한 모든 클라이언트에 전송한다.

			try {
				nickNama = br.readLine();// 닉네임 대기
				// 이름은 접속한 모든 client에게 전송한다.
				sendMessage("[" + nickNama + "] 님 입장하셨습니다.");

				while (true) {
					String inputData = br.readLine();
					if (inputData == null) break; // 연결 끊김(EOF) 감지 → 루프 탈출
					sendMessage("[" + nickNama + "]" + inputData);
				}

			} catch (Exception e) {
				// 강제 종료 등으로 예외가 발생한 경우
				e.printStackTrace();
			} finally {
				// 정상 종료(null)든 예외 종료든 여기서 한 번만 정리
				synchronized (list) {
					list.remove(this);
				}
				sendMessage("[" + nickNama + "] 님이 퇴장하셨습니다.");
				System.out.println("[" + nickNama + "] 님이 퇴장 : 현재인원 = " + list.size() + "명");
				try {
					sk.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		new ServerGUIChatExam();

	}

}