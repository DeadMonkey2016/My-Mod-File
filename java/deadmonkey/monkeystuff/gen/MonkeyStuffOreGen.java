package deadmonkey.monkeystuff.gen;

import java.util.Random;

import deadmonkey.monkeystuff.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MonkeyStuffOreGen implements IWorldGenerator{
	
	private WorldGenerator monkeyite_ore;
	
	public MonkeyStuffOreGen()
	{
		monkeyite_ore = new WorldGenMinable(ModBlocks.monkeyite_ore.getDefaultState(), 9);
	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
        switch(world.provider.getDimension())
        {
        case 0:
        	
        	runGenerator(monkeyite_ore, world, random, chunkX, chunkZ, 15, 0, 16);
        	
        	break;
        	
        case 1:
        	
        	break;
        	
        case -1:
        	
        	break;
        }
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}

}
