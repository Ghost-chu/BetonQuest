package org.betonquest.betonquest.id;

import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.config.QuestPackage;
import org.betonquest.betonquest.api.schedule.Schedule;
import org.betonquest.betonquest.exceptions.ObjectNotFoundException;

/**
 * ID identifying a {@link Schedule}
 */
public class ScheduleID extends ID {

    /**
     * Construct a new ScheduleID in the given package from the provided identifier
     *
     * @param pack       package where the id is defined
     * @param identifier string that defines the id
     * @throws ObjectNotFoundException if no schedule with this id exists
     */
    public ScheduleID(final QuestPackage pack, final String identifier) throws ObjectNotFoundException {
        super(pack, identifier);
        if (getPackage().getConfig().getConfigurationSection("schedules." + getBaseID()) == null) {
            throw new ObjectNotFoundException("Schedule '" + getFullID() + "' is not defined");
        }
    }

    /**
     * Schedules are defined as configuration section and therefore can't provide an instruction.
     * Therefore, this method will always throw an UnsupportedOperationException.
     *
     * @return nothing
     * @throws UnsupportedOperationException as described above
     */
    @Override
    public Instruction generateInstruction() {
        throw new UnsupportedOperationException("Schedules do not provide a single instruction string, instead they are defined as configuration section");
    }
}
