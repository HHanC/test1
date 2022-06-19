package member.dto;

import lombok.*;
import member.domain.MemberEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {
    private int mno;
    private String mid;
    private String mname;
    private String mpassword;

    public MemberEntity toentity(){
        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mname(this.mname)
                .mpassword(this.mpassword)
                .build();
    }
}
