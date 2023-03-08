package Commands;

import java.util.*;
import Buildings.*;
import BuildingMementos.*;
import CommandFactories.*;

public interface Command{

    public abstract void execute();

    public abstract void undo();

    public abstract void redo();

}
