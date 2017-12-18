package purple.mnt.mapper;

import org.springframework.stereotype.Repository;
import purple.mnt.model.MssAppMonitor;

import java.util.List;

@Repository
public interface MssAppMonitorMapper {
    List<MssAppMonitor> getAll();
}
