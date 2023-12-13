package com.coffee.system.config.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "cphbm_uplod_d")
public class BudgetUploadDetail {

    @Id
    @Column(name = "bdgt_yr", nullable = false)
    private String budgetYear;

    @Id
    @Column(name = "item_cd", nullable = false)
    private String itemCode;

    @Id
    @Column(name = "curn_cd", nullable = false)
    private String currencyCode;

    @Id
    @Column(name = "seqno", nullable = false)
    private BigDecimal seqNo;

    @Column(name = "frmw_chng_tmst", nullable = false)
    private Timestamp frameworkChangeTimestamp;

    @Column(name = "stcd", nullable = false)
    private String statusCode;

    @Column(name = "cary_fwrd_amt", nullable = false)
    private BigDecimal carryForwardAmount;

    @Column(name = "limt_amt", nullable = false)
    private BigDecimal limitAmount;

    @Column(name = "reg_dt", nullable = false)
    private String registerDate;

    @Column(name = "reg_tlrno", nullable = false)
    private String registerTellerID;

    @Column(name = "aprv_dt", nullable = false)
    private String approvalDate;

    @Column(name = "aprv_tlrno", nullable = false)
    private String approvalTellerID;

    @Column(name = "rmk", nullable = false)
    private String remark;

    @Column(name = "frst_reg_brcd", nullable = false)
    private String firstRegisterBranchCode;

    @Column(name = "frst_reg_tlrno", nullable = false)
    private String firstRegisterTellerID;

    @Column(name = "frst_reg_dt", nullable = false)
    private String firstRegisterDate;

    @Column(name = "frst_reg_time", nullable = false)
    private String firstRegisterTime;

    @Column(name = "last_chng_brcd", nullable = false)
    private String lastChangeBranchCode;

    @Column(name = "last_chng_tlrno", nullable = false)
    private String lastChangeTellerID;

    @Column(name = "last_chng_dt", nullable = false)
    private String lastChangeDate;

    @Column(name = "last_chng_time", nullable = false)
    private String lastChangeTime;

    // Constructors, getters, and setters

}