package com.ihyeongjin.user_domain.utils

import java.sql.Timestamp
import java.time.Instant

object TimeStampUtils {
    fun currentTimeStamp(): Timestamp = Timestamp.from(Instant.now())
}