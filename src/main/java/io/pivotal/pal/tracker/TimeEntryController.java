package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/time-entries")
@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry updateTimeEntry = timeEntryRepository.update(timeEntryId, expected);

        if(updateTimeEntry == null){
            return new ResponseEntity<>(updateTimeEntry, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updateTimeEntry, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> responseList = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(responseList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long nonExistentTimeEntryId) {
        TimeEntry foundTimeEntry = timeEntryRepository.find(nonExistentTimeEntryId);

        if(foundTimeEntry == null){
            return new ResponseEntity<>(foundTimeEntry, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foundTimeEntry, HttpStatus.OK);
    }
}
