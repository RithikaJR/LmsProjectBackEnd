package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.RoleUpdate;
import com.experion.mainProject.lms.dto.UpdateResponse;
import com.experion.mainProject.lms.entity.UserProfile;

public interface UserProfileService {
    public UpdateResponse update(RoleUpdate roleUpdate);
}
