package dev.intermediatebox.string;
// Tag: String
// Tag: Stack

// Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
//
// In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
//
// The canonical path should have the following format:
//
// The path starts with a single slash '/'.
// Any two directories are separated by a single slash '/'.
// The path does not end with a trailing '/'.
// The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
//
// Return the simplified canonical path.

import java.util.*;

// "/home//foo/" -> "/home/foo"
// "/../" -> "/"
// "/some/../path/to/./folder/." -> "/path/to/folder"
public class SimplifyPath {
  public String run(String path) {
    Stack<String> folders = new Stack<>();

    for (String part: path.split("/")) {
      if (part.isEmpty() || part.equals(".")) {
        continue;
      } else if (part.equals("..")) {
        if (!folders.isEmpty()) {
          folders.pop();
        }
      } else {
        folders.push(part);
      }
    }

    String simplifiedPath = "";
    for (String folder: folders) {
      simplifiedPath += "/" + folder;
    }

    if (simplifiedPath.isEmpty()) {
      return "/";
    }

    return simplifiedPath;
  }
}
