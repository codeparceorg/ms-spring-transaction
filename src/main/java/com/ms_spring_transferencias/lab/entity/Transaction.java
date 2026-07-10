package com.ms_spring_transferencias.lab.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.ms_spring_transferencias.lab.types.TransactionStatusType;
import com.ms_spring_transferencias.lab.types.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Setter
@Getter
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "account_number")
    private String accountId;

    @Column(name = "destination_account", length = 20)
    private String destinationAccount;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "status", nullable = false)
    private TransactionStatusType status;

    @Column(name = "transaction_date",    nullable = false,
    insertable = false,
    updatable = false)
    private OffsetDateTime transactionDate;

    @Column(name = "created_at",     nullable = false,
    insertable = false,
    updatable = false)
    private OffsetDateTime createdAt;

}
