import java.util.Scanner;
public class Epic_Questions {
    public static void main(String[] args) {
        String[] questions = {
                "What is a Hasse diagram?",
                "What is a Lattice?",
                "What is Homomorphism?",
                "What does BNF stand for?",
                "What is a Binary Decision Diagram (BDD)?",
                "What is a semantics?",
                "What does CPU stand for?",
                "What is the function of The von Neumann bottleneck?",
                "What is the Number 1 SuperComputer in the world?",
                "What is the function of the CPU in a computer system?",
                "How many levels are in the Multilevel Machines? ",
                "What is the role of Cache memory in Comp Org?",
                "Negate ¬∀xP(x)",
                "What is a roster method?",
                "If X and y are the two finite sets, such that n(X U Y) = 36, n(X) = 20, n(Y) = 28, then find n( X ∩ Y).",
                "What is the cardinality of \uD835\uDC34, if A = {\uD835\uDC65∈Z | \uD835\uDC65 < 7 and \uD835\uDC65 is odd }?",
                "Determine the missing term in the sequence: 4, 12, __, 108, 324, 972. (Easy)",
                "Is [(A→B)∧A]→B a tautology?",
        };
        String[][] answerChoices = {
                {"A) A Hasse diagram is a type of mathematical diagram used to represent a finite partially ordered set.","B) A Hasse diagram is a software tool used to create 3D models and animations.", "C) A Hasse diagram is a hypothetical chart used to represent complex problem-solving processes and identify potential sources of inconvenience in a systematic way.","D) A Hasse diagram is a type of bar chart used to represent data visually."},
                {"A) In computer science, this term refers to complex, networked structures used in quantum computing, where information is processed in intricate, interconnected arrangements that mimic natural phenomena. ", "B) A lattice is a partially ordered set in which every two elements have both a greatest lower bound and a least upper bound.", "C) A lattice is a type of geometric shape with seven sides and six corners. ","D) These are intricate, ornate patterns formed by intertwining threads or ropes, often used in art and architecture, resembling complex geometric designs."},
                {"A) A misunderstood term referring to the idea that mathematical objects can somehow grow or evolve into more complex structures.","B) A concept in computer graphics that refers to transformations applied to images to make them appear consistent and uniform but not related to algebraic structures. ", "C) A homomorphism is a mathematical concept that arises in various branches of mathematics, such as algebra, group theory, and ring theory.","D) A term used in topology to describe transformations that maintain the shape of objects but are unrelated to algebraic structures."},
                {"A) Binary Number Format. ","B) Bartus-Notation Framework  ", "C) Becker-Navigation Framework  ","D) Backus-Naur Form "},
                {"A) A BDD is a directed graph where each node represents a variable or a decision point. It's used to represent and analyze Boolean functions. ", "B) A document used by individuals to help decide what to have for breakfast. It contains binary choices like \"cereal or pancakes,\" \"coffee or tea,\" and \"fruit or no fruit.\"  ", "C) A chart for determining whether to take a binary approach to life decisions. It offers options like \"Yes\" or \"No\" for life's most critical questions, such as \"Should I wear socks today?\" ", "D) A tool for helping computers make decisions by flipping a binary coin. It consists of a visual representation of a coin toss, where heads (H) means \"yes,\" and tails (T) means \"no\" for computer choices. "},
                {"A) Semantics is the study of the meanings of words and phrases in language, but it's primarily concerned with how grammar and punctuation affect meaning.  ", "B) Semantics, in the context of computer science, linguistics, and philosophy, refers to the study of meaning in language and other symbolic systems.  ", "C) Semantics is the practice of interpreting the emotions and intentions behind a person's words, rather than the literal meaning of what they say. ", "D) Semantics is the field of study that focuses on understanding the meaning of texts, emphasizing the use of tone and context, but not the structure and syntax of language. "},
                {"A) Computer Programming Unit  ","B) Central Processing Unit  ", "C) Cooling Power Unit ", "D) Computational Power Unit " },
                {"A) The primary function of the von Neumann bottleneck is to slow down data transfer and limit the overall performance of a computer system.  ","B) The von Neumann bottleneck is responsible for increasing the computer's energy efficiency by minimizing data transfer speed.  ", "C) It acts as a memory security feature, preventing unauthorized access to the computer's data and instructions.  ", "D) The von Neumann bottleneck is a performance-enhancing feature that speeds up data transfers between the CPU and memory in a computer system.  " },
                {"A) Fujitsu Fugaku  ","B) HPE Cray Lumi ", "C) HPE Cray Frontier  ", "D) HPE Cray Perlmutter  " },
                {"A) The CPU is considered a master of languages, capable of instant translation of any spoken or written language, aiding global communication. ","B) The CPU processes human thoughts and decisions, making it the \"thinking\" component of the computer. ", "C) In a fictional scenario, the CPU is thought to handle conversations, interpreting and generating human speech. It helps the computer engage in chit-chat with the user.  ", "D) The function of the CPU in a computer system is to execute instructions and perform calculations that are essential for the operation of the computer " },
                {"A) 5 levels  ","B) 6 levels  ", "C) 7 levels  ", "D) 4 levels  " },
                {"A) Cache memory translates code and data into different programming languages.  ","B) Cache memory predicts the future, storing data the CPU will need next. ", "C) Cache memory stores accessed data and instructions, reducing the time it takes for the CPU to retrieve information from main memory. ", "D) Cache memory helps keep the CPU cold.  " },
                {"A) ∃x¬P(x) ", "B) ∀xP(x) ", "C) ∃xP(x) ", "D) ¬∀x ¬P(x) "},
                {"A) Its an organised list of individuals in an organisation. ", "B) It uses predicate logic to represent elements of a set. ", "C) Its an unordered collection of distinct objects referred to as elements ", "D) Its a way to show the elements of a set by listing the elements inside of curly brackets. "},
                {"A) 15 ", "B) 12 ", "C) 8 ", "D) 13 "},
                {"A) 5 ", "B) 2 ", "C) 4 ", "D) 3 "},
                {"A) 36 ", "B) 25 ", "C) 92 ", "D) 24 "},
                {"A) true","B) false"},

        };
        char[] correctAnswers = {'A', 'B', 'C', 'D', 'A', 'B', 'B', 'A', 'C', 'D', 'B', 'C','A','D','B','D','A','A'};


        int score = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (String choice : answerChoices[i]) {
                System.out.println(choice);
            }
            System.out.print("Enter your answer (A, B, C or D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i]);
            }

            System.out.println("Your current score: " + score);
        }
        System.out.println("Quiz completed! Your final score: " + score);
    }
}



