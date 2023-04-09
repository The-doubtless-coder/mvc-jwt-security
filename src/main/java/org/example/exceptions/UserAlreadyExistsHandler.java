//package org.example.exceptions;
//
//import org.hibernate.engine.spi.SessionImplementor;
//import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
//
//import javax.transaction.SystemException;
//
//public class UserAlreadyExistsHandler extends ExceptionMapper<UserAlreadyExists> {
//
//    @Override
//    public RuntimeException mapStatusCheckFailure(String s, SystemException e, SessionImplementor sessionImplementor) {
//        return null;
//    }
//
//    @Override
//    public RuntimeException mapManagedFlushFailure(String s, RuntimeException e, SessionImplementor sessionImplementor) {
//        return null;
//    }
//}
