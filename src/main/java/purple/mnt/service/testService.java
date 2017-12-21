package purple.mnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import purple.mnt.mapper.MssAppMonitorMapper;
import purple.mnt.mapper.MssHealthMapper;
import purple.mnt.model.MssAppMonitor;
import purple.mnt.model.MssHealth;

import java.util.List;

@Service
public class testService {

    @Autowired
    private MssHealthMapper mssHealthMapper;

    @Autowired
    private MssAppMonitorMapper mssAppMonitorMapper;

    public List<MssHealth> action()
    {
        List<MssHealth> mssHealthList = mssHealthMapper.getAll();
        return mssHealthList;
    }

    public List<MssAppMonitor> action2()
    {
        List<MssAppMonitor> mssAppMonitorList = mssAppMonitorMapper.getAll();
        return mssAppMonitorList;
    }

}
