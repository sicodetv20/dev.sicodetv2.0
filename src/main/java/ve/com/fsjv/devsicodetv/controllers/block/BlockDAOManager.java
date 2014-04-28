package ve.com.fsjv.devsicodetv.controllers.block;

import java.util.ArrayList;
import java.util.List;
import ve.com.fsjv.devsicodetv.models.Block;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
/**
 *
 * @author TecnoSoluciones-NS
 */
public class BlockDAOManager {
    private Block block;
    public List<Block> list = new ArrayList<Block>();
    
    public BlockDAOManager(){}
    
    public int insert(Block block){
        //ADD THE COMMANDS TO ADD A NEW BLOCK
        return ConstantsApp.OK_PROCESS;
    }
    
    public Block findByAttributes(String key){
        //ADD THE COMMANDS TO GET THE BLOCK SEARCHING BY THE KEY VALUE
        return this.block;
    }
    
    public int update(Block block){
        //ADD THE COMMANDS TO UPDATE THE BLOCK SELECTED
        return ConstantsApp.OK_PROCESS;
    }
    
    public int delete(Block block){
        //ADD THE COMMANDS TO DELETE THE BLOCK SELECTED (UPDATE THE STATUS FROM THE 1 TO 0)
        return ConstantsApp.OK_PROCESS;
    }
    
    public void findAll(){
        //ADD THE COMMANDS TO LIST ALL BLOCKS
    }
    
    public void findAllWithHaveCells(){
        //ADD THE COMMANDS TO LIST ALL BLOCKS WITH the haveCells value "true"
    }
    
    public void findAllLastAdded(){
        //EXAMPLE CODE
        /*
        Block b1 = new Block();
        b1.setId(1);
        b1.setCreateDate(Utils.getCurrentDate());
        b1.setTitle("block 1");
        b1.setDescription("description 1");
        Block b2 = new Block();
        b2.setId(2);
        b2.setCreateDate(Utils.getCurrentDate());
        b2.setTitle("block 2");
        b2.setTitle("description 2");
        Block b3 = new Block();
        b3.setId(3);
        b3.setCreateDate(Utils.getCurrentDate());
        b3.setTitle("block 3");
        b3.setDescription("description 3");
        this.list.add(b1);
        this.list.add(b2);
        this.list.add(b3);*/
        //ADD THE COMMANDS TO LIST ALL LAST ADDED BLOCKS.
    }
}
