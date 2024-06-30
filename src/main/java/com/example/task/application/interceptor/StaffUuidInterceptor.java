package com.example.task.application.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.task.staff.service.StaffService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class StaffUuidInterceptor implements  HandlerInterceptor{
    private final StaffService staffService;

    public StaffUuidInterceptor(StaffService staffService) {
        this.staffService = staffService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String staffUuid = request.getHeader("Staff-UUID");
        if (staffUuid == null || !staffService.validateStaffUuid(staffUuid)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("UNAUTHORIZED");
            return false;
        }
        return true;
    }
}
