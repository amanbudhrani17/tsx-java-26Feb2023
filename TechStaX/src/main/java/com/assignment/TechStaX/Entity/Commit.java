package com.assignment.TechStaX.Entity;

import lombok.Data;

@Data
public class Commit {
    public String username;
    public String message;
    public String profileURL;
    public String commitURL;
}
