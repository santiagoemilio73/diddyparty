public class dannyList 
{  
    private dihNode header;
    private dihNode newest;
    public dannyList()
    {
        header = null;
        newest = null;
    }
    public void add(dihNode added)
    {
        if(header == null)
         {
             header = added;
             newest = header;
         }
        else
        {
            newest.point(added);
            newest = added;
        }
    }
    public void clear(){
        header =null;
        newest = null;
    }
    public void remove(String name){
        if(header == null){
            return;
        }
        if(header.getName().equals(name)){
            header = header.getNext();
            if(header ==null){
                newest=null;
           }
           return;
        }
        dihNode current = header;
        while(current.getNext() != null){
            if(current.getNext().getName().equals(name)){
                if(current.getNext() == newest){
                newest = current;
               }
            
            current.point(current.getNext().getNext());
            return;
            }
            current = current.getNext();
         }
    }
     public void addAfter(String existing, dihNode added)
    {
        dihNode current = header;

        while(current != null)
        {
            if(current.getName().equals(existing))
            {
                added.point(current.getNext());
                current.point(added);

                if(current == newest)
                {
                    newest = added;
                }

                return;
            }

            current = current.getNext();
        }
      }
        public String toString()
      {
        String bob = "";
        dihNode current = header;

        while(current != null)
        {
            bob += current.getName();

            if(current.getNext() != null)
            {
                bob += " => ";
            }

            current = current.getNext();
        }

        return bob;
    }
} 