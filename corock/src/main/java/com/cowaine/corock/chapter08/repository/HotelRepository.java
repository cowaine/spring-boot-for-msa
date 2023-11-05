package com.cowaine.corock.chapter08.repository;

import com.cowaine.corock.chapter08.domain.HotelEntity;
import com.cowaine.corock.chapter08.domain.HotelStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

    // SELECT * FROM hotels WHERE status = :status
    List<HotelEntity> findByStatus(HotelStatus hotelStatus);

    // DELETE FROM hotels WHERE status = :status AND created_at BETWEEN :beginCreatedAt and :endCreatedAt AND name is NULL
    void deleteByStatusInAndCreatedDateBetweenAndNameIsNull(Collection<HotelStatus> hotelStatus, ZonedDateTime beginCreatedAt,
                                                            ZonedDateTime endCreatedAt);

    /**
     * @param hotelId 호텔 아이디
     * @return 호텔 엔티티
     * @throws org.hibernate.hql.internal.ast.QuerySyntaxException {ENTITY} is not mapped
     *                                                             <p>
     *                                                             (caused by {@link java.lang.IllegalArgumentException})
     */
    @Query("SELECT h FROM hotels AS h WHERE h.hotelId = ?1 AND h.status = 0")
    HotelEntity findReadyOne(Long hotelId);

    @Query("SELECT h FROM hotels AS h WHERE h.hotelId = :hotelId AND h.status = :status")
    HotelEntity findOne(@Param("hotelId") Long hotelId, @Param("status") HotelStatus hotelStatus);

}
