package Login.Service;

import java.util.Map;

import Login.Member;

public interface MembershipService {
	public boolean comparePW(String pw, String pwre);

	public boolean MembershipProc(Member member);
	public Map<String, String> getMember();
}
