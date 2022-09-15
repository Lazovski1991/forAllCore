package my.company.core.service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeServiceImpl implements TimeService {

    @Override
    public ZonedDateTime getTime() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }
}
