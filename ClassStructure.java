import java.util.ArrayList;
import java.util.List;

public class ClassStructure {
    /**
     * The name for the class
     */
    private String m_Name;

    /**
     * Member functions for this class
     */
    List<Function> m_Functions = new ArrayList<>();

    public ClassStructure(String _classname) {
        m_Name = _classname;
    }

    void AddFunction(Function function) {
        m_Functions.add(function);
    }

    String GetName() {
        return m_Name;
    }
}