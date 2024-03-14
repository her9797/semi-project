package com.revelup.audit.model.dto;


import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuditDTO implements java.io.Serializable {

    private int fndCode;            // 펀딩코드
    private String fndInsertDttm;   // 펀딩등록일시
    private String auditStat;         // 심사상태
    private String auditApprDt;       // 심사승인일자


}
