// Cancer Diagnosis Expert System
// Everett Holmes
// Spring 2025
// An Expert System using command line interface to take user input, match it against predefined cancer rules and determine based on symptoms the type of cancer.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ExpertSystem {
        
    public static int maxIndex = 1000;
    public static int confRuleNumber, confClauseNumber;
    public static List<Object[]> ruleList = new ArrayList<>();
    public static List<String> malepromptList = new ArrayList<>();
    public static List<String> femalepromptList = new ArrayList<>();
    public static List<Object[]> variableList = new ArrayList<>();
    public static List<Object[]> conclusionList = new ArrayList<>();
    public static List<String> clausevariableList = new ArrayList<>(Collections.nCopies(maxIndex, null));
    public static List<String> derivedglobalvariableList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    
    public static void InitializeKnowledgeBase(){
                
            Object[] variables = { "Male" , "Female","Suspect Cancer", "Cancer", "Lump in breast", "Change in breast size", "Change in breast skin", "Swollen nipples",
            "Pain in breast", "Swollen lymph node", "Skin dimpling", "Postmenopausal vaginal bleeding",
            "In Between Period Bleeding", "Heavy periods", "Difficult urination/bloody urine",
            "Abnormal uterus size", "Sign of disease", "Frequent respiratory infection",
            "Persistent Cough", "Coughing blood", "Wheezing or hoarseness", "Abdominal Swelling",
            "Lower back pain", "Blood in Urine", "Unexplained Weightloss", "Prostate enlargement",
            "Blood in semen", "Erection problem", "Weak flow", "Pain when urinating", "Pelvic pain",
            "Burning Urination", "Frequent urination", "Bone pain/tenderness", "Shortness of breath",
            "Fatigue", "Enlarged lymph nodes", "Skin lesion", "Abnormal pigmented areas",
            "Non-healing sore", "Itching", "Jaundice", "Gastrointestinal Issues", "Dark urine",
            "Abdomen pain", "Indigestion", "Heartburn", "Loss of Appetite", "Vomiting",
            "Difficulty Swallowing", "Chest pressure" };

            variableList.add(variables);

            Object[] conclusions = {"No Cancer", "Breast Cancer", "Cervical Cancer", "Uterine Cancer", "Ovarian Cancer",
            "Skin Cancer", "Pancreatic Cancer", "Liver Cancer", "Bladder Cancer",
            "Kidney Cancer", "Lymphoma", "Lung Cancer", "Stomach Cancer",
            "Esophageal Cancer", "Prostate Cancer"};

            conclusionList.add(conclusions);


             Object[][] rules = {{5, "Suspect Cancer", "Female", "Lump in breast", "Change in breast size", "Change in breast skin", "Swollen nipples", "Pain in breast", "Swollen lymph node", "Breast Cancer"},
             {10, "Suspect Cancer", "Female", "Lump in breast", "No Cancer"},
             {15, "Suspect Cancer", "Female", "Lump in breast", "Change in breast size", "No Cancer"},
             {20, "Suspect Cancer", "Female", "Lump in breast", "Change in breast size", "Change in breast skin", "Breast Cancer"},
             {25, "Suspect Cancer", "Female", "Lump in breast", "Change in breast size", "Change in breast skin", "Swollen nipples", "Breast Cancer"},
             {30, "Suspect Cancer", "Female", "Lump in breast", "Change in breast size", "Change in breast skin", "Swollen nipples", "Pain in breast", "Breast Cancer"},
             {35, "Suspect Cancer", "Female", "Postmenopausal vaginal bleeding", "In Between Period Bleeding", "Heavy periods", "Difficult urination/Bloody Urine", "Cervical Cancer"},
             {40, "Suspect Cancer", "Female", "Postmenopausal vaginal bleeding", "Uterine Cancer"},
             {45, "Suspect Cancer", "Female", "Postmenopausal vaginal bleeding", "In Between Period Bleeding", "Cervical Cancer"},
             {50, "Suspect Cancer", "Female", "Postmenopausal vaginal bleeding", "In Between Period Bleeding", "Heavy periods", "Cervical Cancer"},
             {55, "Suspect Cancer", "Female", "Abnormal uterus size", "Sign of disease", "Ovarian Cancer"},
             {60, "Suspect Cancer", "Female", "Abnormal uterus size", "No Cancer"},
             {75, "Suspect Cancer", "Female", "Abnormal pigmented areas", "Skin Cancer"},
             {80, "Suspect Cancer", "Female", "Gastrointestinal Issues", "Jaundice", "Pancreatic Cancer"},
             {85, "Suspect Cancer", "Female", "Gastrointestinal Issues", "No Cancer"},
             {90, "Suspect Cancer", "Female", "Abdomen pain", "Dark urine", "Liver Cancer"},
             {95, "Suspect Cancer", "Female", "Abdomen pain", "Blood in Urine", "Burning Urination", "Frequent urination", "Bone pain/tenderness", "Bladder Cancer"},
             {100, "Suspect Cancer", "Female", "Abdomen pain", "Blood in Urine", "Burning Urination", "Frequent urination", "Bladder Cancer"},
             {105, "Suspect Cancer", "Female", "Abdomen pain", "Blood in Urine", "Abdominal Swelling", "Unexplained Weightloss", "Kidney Cancer"},
             {110, "Suspect Cancer", "Female", "Abdomen pain", "Blood in Urine", "Burning Urination", "Bladder Cancer"},
             {115, "Suspect Cancer", "Female", "Abdomen pain", "Blood in Urine", "Burning Urination", "Frequent urination", "Bladder Cancer"},
             {120, "Suspect Cancer", "Female", "Blood in Urine", "Abdominal Swelling", "Kidney Cancer"},
             {125, "Suspect Cancer", "Female", "Shortness of breath", "Fatigue", "Enlarged lymph nodess", "Lymphoma"},
             {130, "Suspect Cancer", "Female", "Shortness of breath", "Fatigue", "Persistent Cough", "Coughing blood", "Wheezing or hoarseness", "Unexplained Weightloss", "Lung Cancer"},
             {135, "Suspect Cancer", "Female", "Shortness of breath", "No Cancer"},
             {140, "Suspect Cancer", "Female", "Shortness of breath", "Fatigue", "Persistent Cough", "No Cancer"},
             {145, "Suspect Cancer", "Female", "Shortness of breath", "Fatigue", "Persistent Cough", "Coughing blood", "Lung Cancer"},
             {150, "Suspect Cancer", "Female", "Shortness of breath", "Fatigue", "Persistent Cough", "Coughing blood", "Wheezing or hoarseness", "Lung Cancer"},
             {155, "Suspect Cancer", "Female", "Indigestion", "Heartburn", "Loss of Appetite", "Jaundice", "Vomiting", "Stomach Cancer"},
             {160, "Suspect Cancer", "Female", "Indigestion", "Heartburn", "Difficulty Swallowing", "Chest pressure", "Esophogeal Cancer"},
             {165, "Suspect Cancer", "Female", "Indigestion", "Heartburn", "Loss of Appetite", "No Cancer"},
             {170, "Suspect Cancer", "Female", "Indigestion", "Heartburn", "Loss of Appetite", "Jaundice", "Stomach Cancer"},
             {175, "Suspect Cancer", "Female", "Indigestion", "Heartburn", "Difficulty Swallowing", "No Cancer"},
             {180, "Suspect Cancer", "Female", "No Cancer"},
             {185, "Suspect Cancer", "Male", "Difficult Urination", "Weak flow", "Frequent urination", "Pain when urinating", "Erection problem", "Blood in semen", "Pain in back", "Unexplained Weightloss", "Pelvic pain", "Prostate Cancer"},
             {190, "Suspect Cancer", "Male", "Difficult Urination", "Weak flow", "Frequent urination", "Pain when urinating", "Erection problem", "Blood in semen", "Pain in back", "Unexplained Weightloss", "Prostate Cancer"},
             {195, "Suspect Cancer", "Male", "Difficult Urination", "Weak flow", "Frequent urination", "Pain when urinating", "Erection problem", "Blood in semen", "Pain in back", "Prostate Cancer"},
             {200, "Suspect Cancer", "Male", "Difficult Urination", "Weak flow", "Frequent urination", "Pain when urinating", "Erection problem", "Blood in semen", "Prostate Cancer"},
             {205, "Suspect Cancer", "Male", "Difficult Urination", "Weak flow", "Frequent urination", "Pain when urinating", "Erection problem", "No Cancer"},
             {210, "Suspect Cancer", "Male", "Difficult Urination", "Weak flow", "Frequent urination", "Pain when urinating", "Erection problem", "Blood in semen", "Pain in back", "Unexplained Weightloss", "Pelvic pain", "Prostate Cancer"},
             {215, "Suspect Cancer", "Male", "Abnormal moles or birthmarks", "Abnormal pigmented areas", "Skin Cancer"},
             {220, "Suspect Cancer", "Male", "Abnormal moles or birthmarks", "Skin Cancer"},
             {225, "Suspect Cancer", "Male", "No Cancer"},
             {230, "Suspect Cancer", "Male", "Gastrointestinal Issues", "Jaundice", "Pancreatic Cancer"},
             {235, "Suspect Cancer", "Male", "Gastrointestinal Issues", "No Cancer"},
             {240, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "Jaundice", "Liver Cancer"},
             {245, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "No Cancer"},
             {250, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "Blood in Urine", "Burning Urination", "Frequent urination", "Bone pain/tenderness", "Bladder Cancer"},
             {255, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "Blood in Urine", "Burning Urination", "Frequent urination", "Bladder Cancer"},
             {260, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "Blood in Urine", "Burning Urination", "Bladder Cancer"},
             {265, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "Blood in Urine", "Bladder Cancer"},
             {270, "Suspect Cancer", "Male", "Abdomen pain", "No Cancer"},
             {275, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "Blood in Urine", "Burning Urination", "Abdomen swelling", "Unexplained Weightloss", "Kidney Cancer"},
             {280, "Suspect Cancer", "Male", "Abdomen pain", "Dark urine", "Blood in Urine", "Burning Urination", "Abdomen swelling", "Kidney Cancer"},
             {285, "Suspect Cancer", "Male", "Shortness of breath", "Fatigue", "Enlarged lymph nodess", "Lymphoma"},
             {290, "Suspect Cancer", "Male", "Abdomen pain", "Shortness of breath", "Fatigue", "Persistent Cough", "Coughing blood", "Wheezing or hoarseness", "Unexplained Weightloss", "Lung Cancer"},
             {295, "Suspect Cancer", "Male", "Abdomen pain", "Shortness of breath", "Fatigue", "Persistent Cough", "Coughing blood", "Wheezing or hoarseness", "Lung Cancer"},
             {300, "Suspect Cancer", "Male", "Abdomen pain", "Shortness of breath", "Fatigue", "Persistent Cough", "Coughing blood", "Lung Cancer"},
             {305, "Suspect Cancer", "Male", "Abdomen pain", "Shortness of breath", "Fatigue", "Persistent Cough", "No Cancer"},
             {310, "Suspect Cancer", "Male", "Abdomen pain", "Indigestion", "Heartburn", "Loss of Appetite", "Jaundice", "Vomiting", "Stomach Cancer"},
             {315, "Suspect Cancer", "Male", "Abdomen pain", "Indigestion", "Heartburn", "Loss of Appetite", "Jaundice", "Stomach Cancer"},
             {320, "Suspect Cancer", "Male", "Abdomen pain", "Indigestion", "Heartburn", "Loss of Appetite", "Stomach Cancer"},
             {325, "Suspect Cancer", "Male", "Abdomen pain", "Indigestion", "Heartburn", "Difficulty Swallowing", "Chest Pressure", "Esophageal Cancer"},
             {330, "Suspect Cancer", "Male", "Abdomen pain", "Indigestion", "Heartburn", "Difficulty Swallowing", "Esophageal Cancer"},
             {335, "Suspect Cancer", "Male", "Abdomen pain", "Indigestion", "No Cancer"},
             {340, "Suspect Cancer", "Male", "Abdomen pain", "No Cancer"}};

             
             for (Object[] rule : rules){
                ruleList.add(rule);

             }

             femalepromptList.add("Lump in breast");
             femalepromptList.add("Change in breast size");
             femalepromptList.add("Change in breast skin");
             femalepromptList.add("Swollen nipples");
             femalepromptList.add("Pain in breast");
             femalepromptList.add("Swollen lymph node");
             femalepromptList.add("Postmenopausal vaginal bleeding");
             femalepromptList.add("In Between Period Bleeding");
             femalepromptList.add("Heavy periods");
             femalepromptList.add("Difficult urination/Bloody Urine");
             femalepromptList.add("Abnormal uterus size");
             femalepromptList.add("Sign of disease");
             femalepromptList.add("Abnormal pigmented areas");
             femalepromptList.add("Gastrointestinal Issues");
             femalepromptList.add("Jaundice");
             femalepromptList.add("Abdomen pain");
             femalepromptList.add("Dark urine");
             femalepromptList.add("Blood in Urine");
             femalepromptList.add("Burning Urination");
             femalepromptList.add("Frequent urination");
             femalepromptList.add("Abdominal Swelling");
             femalepromptList.add("Unexplained Weightloss");
             femalepromptList.add("Bone pain/tenderness");
             femalepromptList.add("Shortness of breath");
             femalepromptList.add("Fatigue");
             femalepromptList.add("Enlarged lymph nodess");
             femalepromptList.add("Persistent Cough");
             femalepromptList.add("Coughing blood");
             femalepromptList.add("Wheezing or hoarseness");
             femalepromptList.add("Indigestion");
             femalepromptList.add("Heartburn");
             femalepromptList.add("Vomiting");
             femalepromptList.add("Difficulty Swallowing");
             femalepromptList.add("Chest pressure");



             malepromptList.add("Difficult Urination");
             malepromptList.add("Weak flow");
             malepromptList.add("Frequent urination");
             malepromptList.add("Pain when urinating");
             malepromptList.add("Erection problem");
             malepromptList.add("Blood in semen");
             malepromptList.add("Pain in back");
             malepromptList.add("Unexplained Weightloss");
             malepromptList.add("Pelvic pain");
             malepromptList.add("Abnormal moles or birthmarks");
             malepromptList.add("Abnormal pigmented areas");
             malepromptList.add("Gastrointestinal Issues");
             malepromptList.add("Jaundice");
             malepromptList.add("Abdomen pain");
             malepromptList.add("Dark urine");
             malepromptList.add("Blood in Urine");
             malepromptList.add("Burning Urination");
             malepromptList.add("Frequent urination");
             malepromptList.add("Abdomen swelling");
             malepromptList.add("Shortness of breath");
             malepromptList.add("Fatigue");
             malepromptList.add("Persistent Cough");
             malepromptList.add("Coughing blood");
             malepromptList.add("Wheezing or hoarseness");
             malepromptList.add("Indigestion");
             malepromptList.add("Heartburn");
             malepromptList.add("Loss of Appetite");
             malepromptList.add("Vomiting");
             malepromptList.add("Difficulty Swallowing");
             malepromptList.add("Chest Pressure");

             
             
             


    }

    public static String checkRules(){
        String diagnosis = "";
        if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Lump in breast") &&
           derivedglobalvariableList.contains("Change in breast size") &&
            derivedglobalvariableList.contains("Swollen nipples") &&
             derivedglobalvariableList.contains("Pain in breast") &&
              derivedglobalvariableList.contains("Swollen lymph node")) {
        diagnosis = "Breast Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Lump in breast") &&
          derivedglobalvariableList.contains("Change in breast size") &&
           derivedglobalvariableList.contains("Change in breast skin") && 
           derivedglobalvariableList.contains("Swollen nipples") &&
            derivedglobalvariableList.contains("Pain in breast")) {
            diagnosis = "Breast Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Lump in breast") &&
          derivedglobalvariableList.contains("Change in breast size") &&
           derivedglobalvariableList.contains("Change in breast skin") && 
           derivedglobalvariableList.contains("Swollen nipples")) {
            diagnosis = "Breast Cancer";
        }
        
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Postmenopausal vaginal bleeding") &&
         derivedglobalvariableList.contains("In Between Period Bleeding") &&
          derivedglobalvariableList.contains("Heavy periods") && 
          derivedglobalvariableList.contains("Difficult urination/Bloody Urine")) {
            diagnosis = "Cervical Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Postmenopausal vaginal bleeding") &&
           derivedglobalvariableList.contains("In Between Period Bleeding") &&
            derivedglobalvariableList.contains("Heavy periods")) {
            diagnosis = "Cervical Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Postmenopausal vaginal bleeding") && 
          derivedglobalvariableList.contains("In Between Period Bleeding")) {
            diagnosis = "Cervical Cancer";
        }
        
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
        derivedglobalvariableList.contains("Female") && 
        derivedglobalvariableList.contains("Postmenopausal vaginal bleeding")) {
            diagnosis = "Uterine Cancer";
        }
        
        
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Abnormal uterus size") &&
           derivedglobalvariableList.contains("Sign of disease")) {
            diagnosis = "Ovarian Cancer";
        }
        
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Abnormal uterus size")) {
            diagnosis = "No Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
         derivedglobalvariableList.contains("Female") && 
         derivedglobalvariableList.contains("Abnormal pigmented areas")) {
            diagnosis = "Skin Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Gastrointestinal Issues") && 
                derivedglobalvariableList.contains("Jaundice")) {
            diagnosis = "Pancreatic Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Gastrointestinal Issues")) {
            diagnosis = "No Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Dark urine")) {
            diagnosis = "Liver Cancer";
        }

            else if (derivedglobalvariableList.contains("Suspect Cancer") && 
            derivedglobalvariableList.contains("Female") && 
            derivedglobalvariableList.contains("Abdomen pain") && 
            derivedglobalvariableList.contains("Blood in Urine") && 
            derivedglobalvariableList.contains("Burning Urination") && 
            derivedglobalvariableList.contains("Frequent urination") &&
            derivedglobalvariableList.contains("Bone pain/tenderness")) {
        diagnosis = "Bladder Cancer";
    }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Blood in Urine") && 
                derivedglobalvariableList.contains("Burning Urination") && 
                derivedglobalvariableList.contains("Frequent urination")) {
            diagnosis = "Bladder Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Blood in Urine") && 
                derivedglobalvariableList.contains("Burning Urination")) {
            diagnosis = "Bladder Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Blood in Urine") && 
                derivedglobalvariableList.contains("Abdominal Swelling") && 
                derivedglobalvariableList.contains("Unexplained Weightloss")) {
            diagnosis = "Kidney Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Abdomen pain") &&
                derivedglobalvariableList.contains("Blood in Urine") && 
                derivedglobalvariableList.contains("Abdominal Swelling")) {
            diagnosis = "Kidney Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Shortness of breath") && 
                derivedglobalvariableList.contains("Fatigue") && 
                derivedglobalvariableList.contains("Enlarged lymph nodess")) {
            diagnosis = "Lymphoma";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Shortness of breath") && 
                derivedglobalvariableList.contains("Fatigue") && 
                derivedglobalvariableList.contains("Persistent Cough") && 
                derivedglobalvariableList.contains("Coughing blood") && 
                derivedglobalvariableList.contains("Wheezing or hoarseness") && 
                derivedglobalvariableList.contains("Unexplained Weightloss")) {
            diagnosis = "Lung Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Shortness of breath") && 
                derivedglobalvariableList.contains("Fatigue") && 
                derivedglobalvariableList.contains("Persistent Cough") && 
                derivedglobalvariableList.contains("Coughing blood") && 
                derivedglobalvariableList.contains("Wheezing or hoarseness")) {
            diagnosis = "Lung Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
         derivedglobalvariableList.contains("Female") && 
         derivedglobalvariableList.contains("Shortness of breath") && 
         derivedglobalvariableList.contains("Fatigue") && 
         derivedglobalvariableList.contains("Persistent Cough") && 
         derivedglobalvariableList.contains("Coughing blood")) {
            diagnosis = "Lung Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Loss of Appetite") && 
                derivedglobalvariableList.contains("Jaundice") && 
                derivedglobalvariableList.contains("Vomiting")) {
            diagnosis = "Stomach Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Loss of Appetite") && 
                derivedglobalvariableList.contains("Jaundice")) {
            diagnosis = "Stomach Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Female") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Difficulty Swallowing") && 
                derivedglobalvariableList.contains("Chest pressure")) {
            diagnosis = "Esophogeal Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
        derivedglobalvariableList.contains("Female") && 
        derivedglobalvariableList.contains("Indigestion") && 
        derivedglobalvariableList.contains("Heartburn") && 
        derivedglobalvariableList.contains("Difficulty Swallowing")) {
            diagnosis = "Esophogeal Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Difficult Urination") && 
                derivedglobalvariableList.contains("Weak flow") && 
                derivedglobalvariableList.contains("Frequent urination") && 
                derivedglobalvariableList.contains("Pain when urinating") && 
                derivedglobalvariableList.contains("Erection problem") && 
                derivedglobalvariableList.contains("Blood in semen") && 
                derivedglobalvariableList.contains("Pain in back") && 
                derivedglobalvariableList.contains("Unexplained Weightloss") && 
                derivedglobalvariableList.contains("Pelvic pain")) {
            diagnosis = "Prostate Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Difficult Urination") && 
                derivedglobalvariableList.contains("Weak flow") && 
                derivedglobalvariableList.contains("Frequent urination") && 
                derivedglobalvariableList.contains("Pain when urinating") && 
                derivedglobalvariableList.contains("Erection problem") && 
                derivedglobalvariableList.contains("Blood in semen") && 
                derivedglobalvariableList.contains("Pain in back") && 
                derivedglobalvariableList.contains("Unexplained Weightloss")) {
            diagnosis = "Prostate Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Difficult Urination") && 
                derivedglobalvariableList.contains("Weak flow") && 
                derivedglobalvariableList.contains("Frequent urination") && 
                derivedglobalvariableList.contains("Pain when urinating") && 
                derivedglobalvariableList.contains("Erection problem") && 
                derivedglobalvariableList.contains("Blood in semen") &&
                derivedglobalvariableList.contains("Pain in back")) {
            diagnosis = "Prostate Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Difficult Urination") && 
                derivedglobalvariableList.contains("Weak flow") && 
                derivedglobalvariableList.contains("Frequent urination") && 
                derivedglobalvariableList.contains("Pain when urinating") && 
                derivedglobalvariableList.contains("Erection problem") && 
                derivedglobalvariableList.contains("Blood in semen")) {
            diagnosis = "Prostate Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
         derivedglobalvariableList.contains("Male") && 
         derivedglobalvariableList.contains("Abnormal moles or birthmarks") && 
         derivedglobalvariableList.contains("Abnormal pigmented areas")) {
            diagnosis = "Skin Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abnormal moles or birthmarks")) {
            diagnosis = "Skin Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Gastrointestinal Issues") && 
                derivedglobalvariableList.contains("Jaundice")) {
            diagnosis = "Pancreatic Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Gastrointestinal Issues")) {
            diagnosis = "No Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Dark urine") && 
                derivedglobalvariableList.contains("Jaundice")) {
            diagnosis = "Liver Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") &&  
                derivedglobalvariableList.contains("Blood in Urine") && 
                derivedglobalvariableList.contains("Burning Urination") && 
                derivedglobalvariableList.contains("Frequent urination") && 
                derivedglobalvariableList.contains("Bone pain/tenderness")) {
            diagnosis = "Bladder Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") &&  
                derivedglobalvariableList.contains("Blood in Urine") && 
                derivedglobalvariableList.contains("Burning Urination") && 
                derivedglobalvariableList.contains("Frequent urination")) {
            diagnosis = "Bladder Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Blood in Urine") && 
                derivedglobalvariableList.contains("Burning Urination")) {
            diagnosis = "Bladder Cancer";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
         derivedglobalvariableList.contains("Male") && 
         derivedglobalvariableList.contains("Abdomen pain") &&
         derivedglobalvariableList.contains("Blood in Urine") && 
         derivedglobalvariableList.contains("Abdomen swelling") && 
         derivedglobalvariableList.contains("Unexplained Weightloss")) {
    diagnosis = "Kidney Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Blood in Urine") &&
                derivedglobalvariableList.contains("Abdomen swelling")) {
            diagnosis = "Kidney Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Shortness of breath") && 
                derivedglobalvariableList.contains("Fatigue") && 
                derivedglobalvariableList.contains("Enlarged lymph nodess")) {
            diagnosis = "Lymphoma";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Shortness of breath") && 
                derivedglobalvariableList.contains("Fatigue") && 
                derivedglobalvariableList.contains("Persistent Cough") && 
                derivedglobalvariableList.contains("Coughing blood") && 
                derivedglobalvariableList.contains("Wheezing or hoarseness") && 
                derivedglobalvariableList.contains("Unexplained Weightloss")) {
            diagnosis = "Lung Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Shortness of breath") && 
                derivedglobalvariableList.contains("Fatigue") && 
                derivedglobalvariableList.contains("Persistent Cough") && 
                derivedglobalvariableList.contains("Coughing blood") && 
                derivedglobalvariableList.contains("Wheezing or hoarseness")) {
            diagnosis = "Lung Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Shortness of breath") && 
                derivedglobalvariableList.contains("Fatigue") && 
                derivedglobalvariableList.contains("Persistent Cough") && 
                derivedglobalvariableList.contains("Coughing blood")) {
            diagnosis = "Lung Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Loss of Appetite") && 
                derivedglobalvariableList.contains("Jaundice") && 
                derivedglobalvariableList.contains("Vomiting")) {
            diagnosis = "Stomach Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Loss of Appetite") && 
                derivedglobalvariableList.contains("Jaundice")) {
            diagnosis = "Stomach Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Loss of Appetite")) {
            diagnosis = "Stomach Cancer";
        }

        else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Difficulty Swallowing") && 
                derivedglobalvariableList.contains("Chest Pressure")) {
            diagnosis = "Esophageal Cancer";
        }

            else if (derivedglobalvariableList.contains("Suspect Cancer") && 
                derivedglobalvariableList.contains("Male") && 
                derivedglobalvariableList.contains("Abdomen pain") && 
                derivedglobalvariableList.contains("Indigestion") && 
                derivedglobalvariableList.contains("Heartburn") && 
                derivedglobalvariableList.contains("Difficulty Swallowing")) {
            diagnosis = "Esophageal Cancer";
            }
            else{

                diagnosis = "No Cancer";
            }
        
        
        return diagnosis;
    }
    
    public static String checkRulesT(){
        String Treatment = "";

        if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Female") &&
          derivedglobalvariableList.contains("Lump in breast") &&
           derivedglobalvariableList.contains("Change in breast size") &&
            derivedglobalvariableList.contains("Breast Cancer")) {
        Treatment = "Hormonal Therapy, Targeted Therapy";
            }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
        derivedglobalvariableList.contains("Postmenopausal vaginal bleeding") &&
        derivedglobalvariableList.contains("In Between Period Bleeding") &&
        derivedglobalvariableList.contains("Cervical Cancer")) {
        Treatment = "Surgery, Radiation Therapy";
            }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
        derivedglobalvariableList.contains("Postmenopausal vaginal bleeding") &&
        derivedglobalvariableList.contains("Uterine Cancer")) {
        Treatment = "Immunotherapy, Targeted Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Abnormal uterus size") &&
          derivedglobalvariableList.contains("Sign of disease") &&
           derivedglobalvariableList.contains("Ovarian Cancer")) {
        Treatment = "Surgery, Chemotherapy, Targeted Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Shortness of breath") &&
          derivedglobalvariableList.contains("Fatigue") &&
           derivedglobalvariableList.contains("Enlarged lymph nodes") &&
           derivedglobalvariableList.contains("Lymphoma")) {
        Treatment = "Chemotherapy, Radiation Therapy, Targeted Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Gastrointestinal Issues") &&
          derivedglobalvariableList.contains("Jaundice") &&
           derivedglobalvariableList.contains("Pancreatic Cancer")) {
        Treatment = "Surgery, Chemotherapy, Radiation Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Indigestion") &&
          derivedglobalvariableList.contains("Heartburn") &&
          derivedglobalvariableList.contains("Loss of Appetite") &&
           derivedglobalvariableList.contains("Stomach Cancer")) {
        Treatment = "Surgery, Chemotherapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Difficulty Swallowing") &&
           derivedglobalvariableList.contains("Esophogeal Cancer")) {
        Treatment = "Surgery, Chemotherapy, Radiation Therapy, Laser Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Persistent Cough") &&
          derivedglobalvariableList.contains("Coughing blood") &&
           derivedglobalvariableList.contains("Lung Cancer")) {
        Treatment = "Immunotherapy, Targeted Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Blood in Urine") &&
          derivedglobalvariableList.contains("Abdominal Swelling") &&
           derivedglobalvariableList.contains("Kidney Cancer")) {
        Treatment = "Nephrectomy, Ablation Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Blood in Urine") &&
          derivedglobalvariableList.contains("Burning Urination") &&
           derivedglobalvariableList.contains("Bladder Cancer")) {
        Treatment = "Intravesical Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Abnormal pigmented areas") &&
           derivedglobalvariableList.contains("Skin Cancer")) {
        Treatment = "Photodynamic Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Female") &&
         derivedglobalvariableList.contains("Dark Urine") &&
         derivedglobalvariableList.contains("Jaundice") &&
           derivedglobalvariableList.contains("Liver Cancer")) {
        Treatment = "Transplant, Ablation Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
         derivedglobalvariableList.contains("Male") &&
            derivedglobalvariableList.contains("Difficult Urination") &&
            derivedglobalvariableList.contains("Prostate Cancer")) {
        Treatment = "Hormone Therapy, Surgery, Radiation Therapy, Chemotherapy";
            }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
            derivedglobalvariableList.contains("Male") &&
             derivedglobalvariableList.contains("Shortness of breath") &&
              derivedglobalvariableList.contains("Fatigue") &&
               derivedglobalvariableList.contains("Enlarged lymph nodes") &&
               derivedglobalvariableList.contains("Lymphoma")) {
        Treatment = "Chemotherapy, Radiation Therapy, Targeted Therapy";
            }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
            derivedglobalvariableList.contains("Male") &&
             derivedglobalvariableList.contains("Gastrointestinal Issues") &&
              derivedglobalvariableList.contains("Jaundice") &&
               derivedglobalvariableList.contains("Pancreatic Cancer")) {
        Treatment = "Surgery, Chemotherapy, Radiation Therapy";
            }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
            derivedglobalvariableList.contains("Male") &&
             derivedglobalvariableList.contains("Indigestion") &&
              derivedglobalvariableList.contains("Heartburn") &&
              derivedglobalvariableList.contains("Loss of Appetite") &&
               derivedglobalvariableList.contains("Stomach Cancer")) {
        Treatment = "Surgery, Chemotherapy";
            }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
            derivedglobalvariableList.contains("Male") &&
             derivedglobalvariableList.contains("Difficulty Swallowing") &&
               derivedglobalvariableList.contains("Esophogeal Cancer")) {
        Treatment = "Surgery, Chemotherapy, Radiation Therapy, Laser Therapy";
            }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Male") &&
         derivedglobalvariableList.contains("Persistent Cough") &&
          derivedglobalvariableList.contains("Coughing blood") &&
           derivedglobalvariableList.contains("Lung Cancer")) {
        Treatment = "Immunotherapy, Targeted Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Male") &&
         derivedglobalvariableList.contains("Blood in Urine") &&
          derivedglobalvariableList.contains("Abdominal Swelling") &&
           derivedglobalvariableList.contains("Kidney Cancer")) {
        Treatment = "Nephrectomy, Ablation Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Male") &&
         derivedglobalvariableList.contains("Blood in Urine") &&
          derivedglobalvariableList.contains("Burning Urination") &&
           derivedglobalvariableList.contains("Bladder Cancer")) {
        Treatment = "Intravesical Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Male") &&
         derivedglobalvariableList.contains("Abnormal pigmented areas") &&
           derivedglobalvariableList.contains("Skin Cancer")) {
        Treatment = "Photodynamic Therapy";
        }
        else if (derivedglobalvariableList.contains("Suspect Cancer") &&
        derivedglobalvariableList.contains("Male") &&
         derivedglobalvariableList.contains("Dark Urine") &&
         derivedglobalvariableList.contains("Jaundice") &&
           derivedglobalvariableList.contains("Liver Cancer")) {
        Treatment = "Transplant, Ablation Therapy";
        }
        else{

            Treatment = "None, You don't have cancer";
        }

        return Treatment;
    }

    public static int confirmRN(String diagnosis){
        int ruleNum = 0;

        switch(diagnosis){
            case "No Cancer":
                ruleNum = 5;
                break;
            case "Breast Cancer":
                ruleNum = 10;
                break;
            case "Cervical Cancer":
                ruleNum = 15;
                break;
            case "Uterine Cancer":
                ruleNum = 20;
                break;
            case "Ovarian Cancer":
                ruleNum = 25;
                break;
            case "Skin Cancer":
                ruleNum = 30;
                break;
            case "Pancreatic Cancer":
                ruleNum = 35;
                break;
            case "Liver Cancer":
                ruleNum = 40;
                break;
            case "Bladder Cancer":
                ruleNum = 45;
                break;
            case "Kidney Cancer":
                ruleNum = 50;
                break;
            case "Lymphoma Cancer":
                ruleNum = 55;
                break;
            case "Lung Cancer":
                ruleNum = 60;
                break;
            case "Stomach Cancer":
                ruleNum = 65;
                break;
            case "Esophogeal Cancer":
                ruleNum = 70;
                break;
            case "Prostate Cancer":
                ruleNum = 75;
                break;
            default:
                ruleNum = 0;
                System.out.println("No Rule Number");

        }

        System.out.println("Rule number is: " + ruleNum);

        int clauseNum = rule_to_clause(ruleNum);
        int clauseVarNum = clauseNum;
        System.out.println("Clause number is: " + clauseNum);
        for(String chosen : derivedglobalvariableList){
        //String temp = (String) chosen;  
        clausevariableList.add(clauseVarNum, chosen);
        System.out.println("Clause variable at: " + clauseVarNum);
        clauseVarNum++;
        }
        clausevariableList.add(clauseVarNum+1, diagnosis);
        System.out.println("Clause variable at: " + clauseVarNum);


        return ruleNum;
    }

    public static int search_con(String variable){
        int ruleNumber = -1;

        // Iterate over the rule list
        for (Object[] rule : ruleList) {
            // Check if the variable exists in the conditions part of the rule
            for (int i = 1; i < rule.length - 1; i++) { // Start from index 1 to skip the rule number
                if (rule[i].equals(variable)) {
                    ruleNumber = (int) rule[0]; // If found, get the rule number
                    break; // Exit the loop once the rule is found
                }
            }
            if (ruleNumber != -1) {
                break; // Exit the outer loop if the rule is found
            }
        }
        //System.out.println(ruleNumber);
      return ruleNumber;
    }

    public static int rule_to_clause(int variable){
        int maxVar = 12;
        int total = maxVar * (variable / 5 - 1) + 1; 
        //System.out.println(total);
        return total;
    }

    public static void update_VL(int variable){
        //System.out.println(ruleList.get(0)[0]);
        boolean found = false;

        System.out.println("Do you suspect cancer? ");
        String input1 = scanner.nextLine();
        if("Yes".equals(input1)){
            derivedglobalvariableList.add("Suspect Cancer");
            }
        else{
            System.out.println("You probably don't cancer");
            System.exit(0);
        }
        System.out.println("Are you Male or Female");
        String input2 = scanner.nextLine();
        if("Male".equals(input2) || "male".equals(input2)){
            derivedglobalvariableList.add("Male");
            for(String prompt : malepromptList){
                System.out.println("Do you have  " + prompt + " " + "Yes/No. " + "Enter Done to finalize symptoms");
                String input3 = scanner.nextLine();
                if("Yes".equals(input3)){
                    derivedglobalvariableList.add(prompt);
                }
                else if("Done".equals(input3) || "done".equals(input3)){
                    break;
                }
                else if("No".equals(input3) || "no".equals(input3)){
                    continue;
                }
                else{
                    System.out.println("Input not accepted.");
                    continue;
                }
            }

        }
        else if ("Female".equals(input2) || "female".equals(input2)){
            derivedglobalvariableList.add("Female");
            for(String prompt : femalepromptList){
                System.out.println("Do you have  " + prompt + " " + "Yes/No. " + "Enter Done to finialize symptoms");
                String input4 = scanner.nextLine();
                if("Yes".equals(input4)){
                    derivedglobalvariableList.add(prompt);
                }
                else if("Done".equals(input4) || "done".equals(input4)){
                    break;
                }
                else if("No".equals(input4) || "no".equals(input4)){
                    continue;
                }
                else{
                    System.out.println("Input not accepted.");
                    continue;
                }

            }

        }
        else{
            System.out.println("Please restart and choose acceptable answers.");
            System.exit(0);

        }
       //while(found != false){
        //System.out.println("Do you have  " + " " + "Yes/No");  
        //}
    }

    public static String validate_Ri(int variable, String conclusion){
        conclusion = null;
        
        conclusion = checkRules();


        return conclusion;
    }

    public static String validate_RiT(int variable, String variable2){
        variable2 = null;
        
        variable2 = checkRulesT();


        return variable2;
    }

    public static String processBC(String variable){
        //variable = "Suspect Cancer";
        int ruleNumber;
        int clauseNumber;
        String diagnosis;
        String var1 = "";
        //for(int i = 0; i<66; i++){
            //for (Object[] rule : ruleList) {

            
            ruleNumber = search_con(variable);
            clauseNumber = rule_to_clause(ruleNumber);
            update_VL(clauseNumber);
            diagnosis = validate_Ri(ruleNumber, var1);
            //System.out.println(ruleNumber);
            confRuleNumber = confirmRN(diagnosis);
            confClauseNumber = rule_to_clause(confRuleNumber);
            //System.out.println(confRuleNumber);
            derivedglobalvariableList.add(diagnosis);
            System.out.println("The cancer diagnosis is: " + diagnosis);



            //int testval = (int) rule[0];
            //System.out.println(ruleNumber);

        //}
        return diagnosis;
    }
    
    public static String processFC(String variable){
        String cancerTreatment = "";
        String blank = "";
        int clauseVarNum = search_cvl(variable);
        int ruleVarNum = clause_to_rule(clauseVarNum);
        //System.out.println("Diagnosis Rule and Clause #'s: " + ruleVarNum + " " + clauseVarNum);
        cancerTreatment = validate_RiT(ruleVarNum, variable);
        
        if(!cancerTreatment.equals(blank)){
        System.out.println("Treatment Options Found!");
        }
        else{
            System.out.println("Error, no treatment found!");
        }

        return cancerTreatment;
    }

    public static int search_cvl(String variable){
        int cNumber = 0;
        for(String clause : clausevariableList){
            if (variable.equals(clause))
                cNumber = clausevariableList.indexOf(clause);

        }
        //System.out.println("Diagnosis Clause #: " + cNumber);
        return cNumber;
    }

    public static int clause_to_rule(int variable){
        int ruleNum = 0;

        ruleNum = ((5*(variable/12))+1);
        //System.out.println("Diagnosis Rule #: " + ruleNum);

        return ruleNum;
    }

    public static void main(String[] args) {
        InitializeKnowledgeBase();

        System.out.println("Welcome to the Cancer Diagnosis Expert System!");
        String goalVariable = "Suspect Cancer";
        String diagnosis = processBC(goalVariable);
        if (diagnosis == null) {
            System.out.println("Goal cannot be determined");
            System.exit(0);
        }
        System.out.println("\nCancer Diagnosis:");
        System.out.println("+----------------------+");
        System.out.println("| " + diagnosis + "   |");
        System.out.println("+----------------------+");

        // Processing cancer treatment
        String treatment = processFC(diagnosis);

        System.out.println("+--------------------------+");
        System.out.println("| " + (treatment.isEmpty() ? "No treatment found" : treatment) + " |");
        System.out.println("+--------------------------+");

        System.out.println("\nDerived Conclusion/Variable List:");
        System.out.println("+--------------------------------------+");
        for (String listItem : derivedglobalvariableList) {
            System.out.println("| " + listItem + " |");
        }
        System.out.println("+--------------------------------------+");
        scanner.close();
    }
}

