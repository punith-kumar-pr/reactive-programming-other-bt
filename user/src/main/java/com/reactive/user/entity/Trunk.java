package com.reactive.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("trunk")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trunk {
    @Column("trunk_ossid")
    private String trunkOssid;

    @Column("pbx_type")
    private String pbxType;

    @Column("tenent_id")
    private String tenentId;

    @Column("primary_pop")
    private String primaryPop;

    @Column("secondary_pop")
    private String secondaryPop;

}
