
import java.util.*;

abstract class JobRole {

    public abstract String getRoleName();

    public abstract List<String> getRequiredSkills();
}

class SoftwareEngineer extends JobRole {

    public String getRoleName() {
        return "Software Engineer";
    }

    public List<String> getRequiredSkills() {
        return Arrays.asList("Java", "Algorithms", "Data Structures", "Git");
    }
}

class DataScientist extends JobRole {

    public String getRoleName() {
        return "Data Scientist";
    }

    public List<String> getRequiredSkills() {
        return Arrays.asList("Python", "Machine Learning", "Statistics", "Pandas");
    }
}

class ProductManager extends JobRole {

    public String getRoleName() {
        return "Product Manager";
    }

    public List<String> getRequiredSkills() {
        return Arrays.asList("Communication", "Roadmapping", "Stakeholder Management");
    }
}

class Resume<T extends JobRole> {

    private String candidateName;
    private List<String> candidateSkills;
    private T jobRole;

    public Resume(String candidateName, List<String> candidateSkills, T jobRole) {
        this.candidateName = candidateName;
        this.candidateSkills = candidateSkills;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public boolean isEligible() {
        return candidateSkills.containsAll(jobRole.getRequiredSkills());
    }
}

class ResumeScreeningSystem {

    // Generic method to process any type of resume
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing resume for: " + resume.getCandidateName());
        System.out.println("Applying for: " + resume.getJobRole().getRoleName());
        if (resume.isEligible()) {
            System.out.println("Status: Eligible ✅");
        } else {
            System.out.println("Status: Not Eligible ❌");
        }
        System.out.println();
    }

    // Wildcard method to display roles
    public static void listJobRoles(List<? extends JobRole> roles) {
        System.out.println("Available Job Roles:");
        for (JobRole role : roles) {
            System.out.println("- " + role.getRoleName());
        }
    }
}

public class P5 {

    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer();
        DataScientist ds = new DataScientist();

        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", Arrays.asList("Java", "Git", "Algorithms", "Data Structures"), se);
        Resume<DataScientist> resume2 = new Resume<>("Bob", Arrays.asList("Python", "Pandas", "Statistics"), ds);

        ResumeScreeningSystem.processResume(resume1);
        ResumeScreeningSystem.processResume(resume2);

        // Display available roles using wildcard method
        List<JobRole> roles = Arrays.asList(se, ds, new ProductManager());
        ResumeScreeningSystem.listJobRoles(roles);
    }
}
