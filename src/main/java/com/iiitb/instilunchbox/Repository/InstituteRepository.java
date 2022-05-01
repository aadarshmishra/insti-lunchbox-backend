package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.Institute;
import java.util.Optional;

public interface InstituteRepository {
    Optional<Institute> findInstituteByEmail(String email);
}
