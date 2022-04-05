class hive:
	def __init__ (self, scoutbeecount, selectedbeecount, bestbeecount,
				selsitescount, bestsitescount,
				range_list, beetype):
		
		self.scoutbeecount = scoutbeecount
		self.selectedbeecount = selectedbeecount
		self.bestbeecount = bestbeecount		
		
		self.selsitescount = selsitescount
		self.bestsitescount = bestsitescount
		
		self.beetype = beetype
		
		self.range = range_list
		
		self.bestposition = None
		
		self.bestfitness = -1.0e9
		
		beecount = scoutbeecount + selectedbeecount * selsitescount + bestbeecount * bestsitescount
		self.swarm = [beetype() for n in range (beecount)]

		self.bestsites = []
		self.selsites = []
		
		self.swarm.sort (reverse = True)
		self.bestposition = self.swarm[0].getposition()
		self.bestfitness = self.swarm[0].fitness
	
	def sendbees (self, position, index, count):
		for n in range (count):
			if index == len (self.swarm):
				break
			
			curr_bee = self.swarm[index]
			
			if curr_bee not in self.bestsites and curr_bee not in self.selsites:
				curr_bee.goto (position, self.range)
			
			index += 1
		
		return index
	
	def nextstep (self):
		self.bestsites = [self.swarm[0]]
		
		curr_index = 1
		for currbee in self.swarm [curr_index: -1]:
			if currbee.otherpatch (self.bestsites, self.range):
				self.bestsites.append (currbee)
						
				if len (self.bestsites) == self.bestsitescount:
					break
				
			curr_index += 1
		
		self.selsites = []
		
		for currbee in self.swarm [curr_index: -1]:
			if currbee.otherpatch (self.bestsites, self.range) and currbee.otherpatch (self.selsites, self.range):
				self.selsites.append (currbee)
					
				if len (self.selsites) == self.selsitescount:
					break

		bee_index = 1
		
		for best_bee in self.bestsites:
			bee_index = self.sendbees (best_bee.getposition(), bee_index, self.bestbeecount)
			
		for sel_bee in self.selsites:
			bee_index = self.sendbees (sel_bee.getposition(), bee_index, self.selectedbeecount)	

		for curr_bee in self.swarm[bee_index: -1]:
			curr_bee.gotorandom()
	
		self.swarm.sort (reverse = True)
		self.bestposition = self.swarm[0].getposition()
		self.bestfitness = self.swarm[0].fitness