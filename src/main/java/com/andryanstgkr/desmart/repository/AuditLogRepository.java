package com.andryanstgkr.desmart.repository;

import com.andryanstgkr.desmart.model.AuditLog;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends BaseRepository<AuditLog, String>{
    
}
