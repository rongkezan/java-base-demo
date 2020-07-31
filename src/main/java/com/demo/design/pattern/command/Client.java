package com.demo.design.pattern.command;

interface Command{
    void execute();

    void undo();
}

class LightOnCommand implements Command{
    private LightReceiver light;

    public LightOnCommand(LightReceiver light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command{
    private LightReceiver light;

    public LightOffCommand(LightReceiver light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

class NoCommand implements Command{

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}

class LightReceiver{
    public void on(){
        System.out.println("电灯打开了");
    }

    public void off(){
        System.out.println("电灯关闭了");
    }
}

class RemoteController{
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteController(){
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int idx, Command onCommand, Command offCommand){
        onCommands[idx] = onCommand;
        offCommands[idx] = offCommand;
    }

    public void onButtonIsPushed(int idx){
        onCommands[idx].execute();
        undoCommand = onCommands[idx];
    }

    public void offButtonIsPushed(int idx){
        offCommands[idx].execute();
        undoCommand = offCommands[idx];
    }

    public void undoButtonIsPushed(int idx){
        undoCommand.undo();
    }
}

public class Client {
    public static void main(String[] args) {
        LightReceiver lightReceiver = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("---- 按下开灯按钮 ----");
        remoteController.onButtonIsPushed(0);
        System.out.println("---- 按下关灯按钮 ----");
        remoteController.offButtonIsPushed(0);
        System.out.println("---- 按下撤销按钮 ----");
        remoteController.undoButtonIsPushed(0);
    }
}
