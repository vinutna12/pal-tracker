package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    HashMap<Long, TimeEntry> timeEntryMap = new HashMap<Long, TimeEntry>();
    private long index = 1L;

    public TimeEntry create(TimeEntry timeEntry){

        TimeEntry timeEntry1 = new TimeEntry(index++, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(timeEntry1.getId(), timeEntry1);

        return timeEntryMap.get(timeEntry1.getId());
    }

    public TimeEntry find(long id) {

      return timeEntryMap.get(id);
    }

    public List list() {
        return timeEntryMap.values().stream().collect(Collectors.toList());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        timeEntryMap.replace(id, new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours()));

        return timeEntryMap.get(id);
    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }
}
