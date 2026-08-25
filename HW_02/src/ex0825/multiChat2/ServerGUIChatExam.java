package ex0825.multiChat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerGUIChatExam {

	List<ClientSkThread> list = new ArrayList<ServerGUIChatExam.ClientSkThread>();
	Socket sk;

	public ServerGUIChatExam() {
		try (ServerSocket server = new ServerSocket(8002)) {
			while (true) {
				System.out.println("Client 접속 대기중입니다.");
				sk = server.accept();
				ClientSkThread th = new ClientSkThread();
				th.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자 끝

	/**
	 * 모든 client에게 데이터 전송하는 메소드
	 */
	public void sendMessage(String message) {
		for (ClientSkThread th : list) {
			th.pw.println(message);
		}
	}
///////////////////////////////////////////////////////////////////////////

	/**
	 * 접속한 클라이언트의 sk를 Thread로 만들어서 관리
	 */
	class ClientSkThread extends Thread {
		PrintWriter pw;
		BufferedReader br;
		String nickName;

		ClientSkThread() {
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
				while(true) {
					// 닉네임 대기
					nickName = br.readLine();
					
					// 중복 여부 확인 변수
                    boolean duplicated = false;

                    // 기존 닉네임 검사
                    for (ClientSkThread socketThread : list) {
                        if (socketThread.nickName.equals(nickName)) {
                            duplicated = true;
                            break;
                        }
                    }
                    
                    // 닉네임 사용 불가능
                    if (duplicated) {
                        pw.println("DUPLICATED");
                        continue;
                    }

                    // 닉네임 사용 가능
                    list.add(this);
                    pw.println("OK");
                    sendMessage("[" + nickName + "]님이 입장하셨습니다.");
    				System.out.println(sk.getInetAddress() + "님 접속하셨습니다.");
    				System.out.println("현재 접속 인원 : " + list.size()+"명\n");
                    break;
				}

				while (true) {
					String inputData = br.readLine();
					sendMessage("[" + nickName + "]" + inputData);
				}

			} catch (Exception e) {
				//e.printStackTrace();
				//현재 스레드를 list에 제거한다.
				list.remove(this);
				
				//남은 클라이언트에게 메시지 전송
				sendMessage("[" + nickName + "] 님이 퇴장하셨습니다.");
				
				//콘솔에 메시지 출력
				System.out.println("[" + nickName + "] 님이 퇴장 : 현재인원 = " + list.size()+"명");
				
				
			}

		}
	}

	public static void main(String[] args) {
		new ServerGUIChatExam();

	}

}