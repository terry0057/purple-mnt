package purple.mnt.mapper;

import org.springframework.stereotype.Repository;
import purple.mnt.model.MssHealth;
import java.util.List;

@Repository
public interface MssHealthMapper {
    List<MssHealth> getAll222();
}
