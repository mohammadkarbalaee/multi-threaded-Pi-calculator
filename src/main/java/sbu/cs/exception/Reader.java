package sbu.cs.exception;

import java.util.List;

public class Reader
{
    public void readTwitterCommands(List<String> args) throws UnrecognizedCommandException, NotImplementedCommandException
    {
        for (String command : args)
        {
            if (!isRecognizable(command))
            {
                throw new UnrecognizedCommandException();
            }
            else if (!isImplemented(command))
            {
                throw new NotImplementedCommandException();
            }
        }
    }

    private boolean isRecognizable(String command)
    {
        if (Util.getNotImplementedCommands().contains(command) || Util.getImplementedCommands().contains(command))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean isImplemented(String command)
    {
        if (Util.getImplementedCommands().contains(command))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void read(String...args) throws BadInputException
    {
        Integer integer;

        for (int i = 1; i < args.length; i += 2)
        {
            try
            {
                integer = Integer.parseInt(args[i]);
            }
            catch (Exception e)
            {
                throw new BadInputException();
            }
        }
    }
}
