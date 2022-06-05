package ru.homework.my;

public class Team {
    private String name;
    private Members[] members;

    public Team(String name, Members... members) {
        this.name = name;
        this.members = members;
    }

    public Members[] getMembers() {
        return members;
    }

    public void setMembers(Members[] members) {
        this.members = members;
    }

    public String getName(){
        return "Название команды: " + name;
    }

    public void showResult() {
        System.out.println("Имя команды: " + name);
        for (Members member : members) {
            member.result();
        }
    }

    public void positiveResult(){
        System.out.println("Имя команды: " + name);
        for (Members members : members){
            if (members.isOnDistance()) members.result();
        }
    }
}
