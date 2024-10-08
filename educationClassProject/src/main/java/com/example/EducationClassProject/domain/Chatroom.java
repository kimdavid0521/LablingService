package com.example.EducationClassProject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Chatroom extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(nullable = false, length = 40)
    private String name;

    private boolean isSecret;

    private String password;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer peopleNum; // 현재 입장되어있는 사람 수

    // 현재 입장되어있는 사람 수 업데이트 편의 메서드
    public void updatePeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }
}
