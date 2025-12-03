namespace Gifts;

public class ChildrenRepository : IChildrenRepository
{
    private readonly List<Child> _children = [];
    
    public Child? GetChild(string childName)
    {
        Child? found = null;
        for (int i = 0; i < _children.Count; i++)
        {
            var currentChild = _children[i];
            if (currentChild.Name == childName)
            {
                found = currentChild;
            }
        }

        return found;
    }

    public void Add(Child child)
    {
        _children.Add(child);
    }
}