package com.cg.fms.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.dao.ScheduledFlightDao;
import com.cg.fms.entities.ScheduledFlight;
import com.cg.fms.exceptions.ScheduledFlightNumberNotFoundException;
import com.cg.fms.exceptions.NoRecordFoundException;
import com.cg.fms.exceptions.ScheduleIdNotMatchException;
import com.cg.fms.exceptions.ScheduledFlightNotFoundException;

@Service("scheduledFlightService")
public class ScheduledFlightService {

	@Autowired
	ScheduledFlightDao sfdao;

	public ScheduledFlight createScheduledFlight(ScheduledFlight scheduledFlight) {

		return sfdao.save(scheduledFlight);
	}

	public ScheduledFlight modifyScheduledFlight(long id,ScheduledFlight scheduledFlight) {
			if (id == scheduledFlight.getId()) {
				if (sfdao.existsById(id)) {
					return sfdao.save(scheduledFlight);
				} else
					throw new ScheduledFlightNotFoundException("Schedule Flight with id: " + scheduledFlight.getId() + " Not Present!!");
			}
			throw new ScheduleIdNotMatchException("ScheduledFlightId not Matched");

		}

	public ScheduledFlight viewScheduledFlight(long id) {
		Optional<ScheduledFlight> findById = sfdao.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		// throw exception if scheduled flight not found
		else
			throw new ScheduledFlightNumberNotFoundException("No scheduled flight found for flight number " + id);
	}

	public List<ScheduledFlight> viewScheduledFlights() {
		return sfdao.findAll();
	}

	public String deleteScheduledFlight(long id) {
		Optional<ScheduledFlight> findById = sfdao.findById(id);
		if (findById.isPresent()) {
			sfdao.deleteById(id);
			return "Deletion Success with id - " + id;
		} else {
			throw new NoRecordFoundException("No Record Found with id - " + id + " To Delete");
		}
	}


}
