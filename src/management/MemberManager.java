package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String , Member> members;

    public MemberManager() {
        this.members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        if(members.isEmpty())
            return null;
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        members.get(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        if(members.isEmpty())
            return null;
        return members.get(memberId).getLastTransaction();
    }
}
