import family.Person;
import family.FamilyTree;
import family.FamilyException;
import family.IdentityException;
import family.GenderException;

class TestTree
{
    public static void main(String[] args)throws FamilyException, 
			 IdentityException,
			 GenderException
    {/*
        Person dave = new Person("dave",true);
        Person alan = new Person("alan",true);
        Person john = new Person("john",true);
        FamilyTree thisTree = new FamilyTree();
        thisTree.addPerson(dave);
        thisTree.addPerson(alan);
        thisTree.addPerson(john);
        for(int i=0;i<3;i++)
            {
	System.out.println("Person: " + thisTree.getPerson(i));
            }
        //thisTree.addPerson(dave);
        
        System.out.println("No of People: " + thisTree.getNumberOfPersons());

        thisTree.removePerson(dave);
        for(int i=0;i<thisTree.getNumberOfPersons();i++)
            {
	System.out.println("Person: " + thisTree.getPerson(i));
            }
        
       // Person pete = new Person("pete",true);
       // thisTree.removePerson(pete);
        

        System.out.println(thisTree.isEmpty());
        thisTree.removePerson(alan);
        thisTree.removePerson(john);
        System.out.println(thisTree.isEmpty());
        System.out.println("Iterator: " + thisTree.getTreeIterator());
     */

        Person dave = new Person("dave",true);
        Person fred = new Person("fred",true);
        Person bill = new Person("bill",true);
        Person margaret = new Person("margaret",false); 
        Person helen = new Person("helen",false);
        Person sarah = new Person("sarah",false);
        FamilyTree thisTree = new FamilyTree();
        thisTree.addPerson(dave);
        thisTree.addPerson(fred);
        thisTree.addPerson(bill);
        thisTree.addPerson(margaret);
        thisTree.addPerson(helen);
        thisTree.addPerson(sarah);
       
        //thisTree.setFatherOf(dave, dave);
        //thisTree.setFatherOf(dave, margaret);
        //thisTree.setFatherOf(dave, fred);
        //thisTree.setMotherOf(helen, helen);
        //thisTree.setMotherOf(helen, dave);
        //thisTree.setMotherOf(helen, sarah);
        //thisTree.setMotherOf(sarah, helen);
        //thisTree.setFatherOf(dave, fred);
        //thisTree.setFatherOf(fred, dave);
        thisTree.setMotherOf(helen,sarah);
        thisTree.setMotherOf(sarah,helen);
        
    }
}
