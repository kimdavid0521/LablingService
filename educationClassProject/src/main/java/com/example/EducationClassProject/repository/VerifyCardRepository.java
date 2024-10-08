package com.example.EducationClassProject.repository;

import com.example.EducationClassProject.domain.VerifyCard;
import com.example.EducationClassProject.domain.enums.Verify;
import com.example.EducationClassProject.repository.customRepository.VerifyCardRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VerifyCardRepository extends JpaRepository<VerifyCard, Long>, VerifyCardRepositoryCustom {

    // userId로 verify 카드가 존재하는지 확인
    boolean existsVerifyCardByUserId(UUID userId);

    // 인증이 완료된 verifyCard 조회
//    @Query("SELECT v FROM VerifyCard v WHERE v.user.verify = :verify")
//    Page<VerifyCard> findByUserVerify(@Param("verify") Verify verify, Pageable pageable);

}
