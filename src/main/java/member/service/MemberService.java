package member.service;

import member.domain.MemberEntity;
import member.domain.MemberRepository;
import member.dto.MemberDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Integer save(MemberDto memberDto){return memberRepository.save(memberDto.toentity()).getMno();}

    public JSONArray getlist(){
        List<MemberEntity> members = memberRepository.findAll();
        JSONArray jsonArray = new JSONArray();
        return jsonArray;
    }

    public JSONObject get(int mno){
        Optional<MemberEntity> optionalmember = memberRepository.findById(mno);
        MemberEntity member = optionalmember.get();
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }

    @Transactional
    public boolean update(MemberDto memberDto){

        Optional<MemberEntity> optionalmember = memberRepository.findById(memberDto.getMno());
        MemberEntity member = optionalmember.get();
        member.setMid(memberDto.getMid());
        member.setMname(memberDto.getMname());
        return true;
    }
    @Transactional
    public boolean delete(int mno){

        Optional<MemberEntity> optionalmember = memberRepository.findById(mno);
        MemberEntity member = optionalmember.get();
        memberRepository.delete(member);
        return true;
    }
}
