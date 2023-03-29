using System.Collections.Generic;


internal class Program
{
    private static void Main(string[] args)
    {
        string[] familyMembers = { "Fred", "Jon", "David", "Alan", "Charlie", "Hollie" };

        LinkedList<string> family = new LinkedList<string>(familyMembers);
        foreach (var member in family)
        {
            Console.Write($"{member} ->");
        }
        Console.WriteLine();
        Console.WriteLine($"Family member count {family.Count}");

        // The middle node is half of the total linked list items (Count) divided by 2
        // If the count is even, then delete both items in the centre
        //var middleItems = /
        var remainder = 0;
        var quotient = Math.DivRem(family.Count, 2, out remainder);

        Console.WriteLine($"{quotient}, {remainder}");
        var middleListItem = family.ElementAt(quotient);

        Console.WriteLine(middleListItem);
        family.Remove(middleListItem);

        if (remainder == 0)
        {
            family.Remove(family.ElementAt(quotient - 1));
        }

        foreach (var member in family)
        {
            Console.Write($"{member} ->");
        }
        Console.WriteLine();
        Console.WriteLine($"Family member count {family.Count}");
    }
}