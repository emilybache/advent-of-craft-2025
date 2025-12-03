namespace Gifts;

public class Child
{
    public string Name { get; }
    public BehaviorType Behavior { get; }
    public List<Toy> Wishlist { get; private set; }

    public Child(string name, BehaviorType behavior)
    {
        Name = name;
        Behavior = behavior;
        Wishlist = [];
    }

    public void SetWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice)
        => Wishlist = [firstChoice, secondChoice, thirdChoice];

    public Toy? getToy() 
        => Behavior switch
        {
            BehaviorType.NAUGHTY => Wishlist[^1],
            BehaviorType.NICE => Wishlist[1],
            BehaviorType.VERY_NICE => Wishlist[0],
            _ => null
        };
}

public enum BehaviorType
{
    NAUGHTY,
    NICE,
    VERY_NICE
}