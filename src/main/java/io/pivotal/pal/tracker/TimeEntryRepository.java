package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public void delete(long timeEntryId);

    public TimeEntry update(long timeEntryId, TimeEntry expected);

    public List list();

    public TimeEntry find(long nonExistentTimeEntryId);

    public TimeEntry create(TimeEntry timeEntryToCreate);
}
