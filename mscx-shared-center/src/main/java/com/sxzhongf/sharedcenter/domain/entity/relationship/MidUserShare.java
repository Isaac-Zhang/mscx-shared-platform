package com.sxzhongf.sharedcenter.domain.entity.relationship;

import javax.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mid_user_share")
public class MidUserShare {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * share.id
     */
    @Column(name = "share_id")
    private Long shareId;

    /**
     * user.id
     */
    @Column(name = "user_id")
    private Long userId;
}