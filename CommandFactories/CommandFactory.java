package CommandFactories;

import java.util.*;
import Commands.*;
import BuildingMementos.*;
import Buildings.*;

public interface CommandFactory{
    public abstract Command createCommand();
}