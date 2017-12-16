package purple.mnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import purple.mnt.mapper.MssHealthMapper;
import purple.mnt.model.MssHealth;

import java.util.List;

@Service
public class testService {

    @Autowired
    private MssHealthMapper mssHealthMapper;

    public List<MssHealth> action()
    {
        List<MssHealth> mssHealthList = mssHealthMapper.getAll222();
        return mssHealthList;
    }
}
