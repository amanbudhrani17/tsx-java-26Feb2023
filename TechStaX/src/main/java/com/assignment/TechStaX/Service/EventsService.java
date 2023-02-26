package com.assignment.TechStaX.Service;

import com.assignment.TechStaX.Entity.Commit;
import com.assignment.TechStaX.Entity.Event;

import java.util.List;

public interface EventsService {
    public Event eventsLog(String str);
    public List<Commit> commitLog();
}
