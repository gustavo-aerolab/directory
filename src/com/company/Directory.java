package com.company;



import java.util.*;


class Directory {

    private final String path;
    private Directory root;
    private HashMap<String, Directory> subDirectories = new HashMap<>();


    public Directory(String path) {
        this.path = path;
    }

    public boolean equal(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Directory other = (Directory) obj;
        if (path == null)
            return other.path == null;
        else {
            return path.equals(other.path);
        }

    }

    public void addSubDirectory(String path){
        if(path == null || path.chars().allMatch(Character::isWhitespace))
            return;
        if(this.subDirectories.get(path) != null)
            System.out.println("Error, path directory currently exist");

        Directory newDirectory = new Directory(path);
        newDirectory.root = this;
        this.subDirectories.put(newDirectory.getpath(), newDirectory);
    }

    public Directory getSubdirectory(String path){
        Directory subDirectory =  this.subDirectories.get(path);
        if(subDirectory == null)
            System.out.println("Sub directory doesn't exist");

        return subDirectory;
    }

    public void printFullPathDirectory() {
        List<String> pathDirectories = new ArrayList<>();
        pathDirectories.add(this.path);

        Directory current = this;
        while (current.root != null) {

            pathDirectories.add(current.root.path);

            current = current.root;
        }

        Collections.reverse(pathDirectories);
        pathDirectories.forEach(i -> {
            System.out.format("/%s", i);

        });

    }

    public void getSubdirectories(){
        System.out.println(this.subDirectories.keySet());
    }



    public String getpath() {
        return path;
    }

    public Directory getRoot() {
        return root;
    }

    public void setRoot(Directory root) {
        this.root = root;
    }




}







