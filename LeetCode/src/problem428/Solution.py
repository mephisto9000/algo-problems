"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: Node
        :rtype: str
        """
                
        if root == None:
            return None      
        ans = str(root.val)
        if (len(root.children)>0):
            ans+='['
            for idx, child in enumerate(root.children):
                if (idx > 0):
                    ans += ','
                ans += self.serialize(child)
            ans+=']'
            
        #print(ans)
        return ans
        
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: Node
        """
        if (data == None):
            return None
        #return None
        #print('hhh', data)
        bracketPos = data.find('[')
        children = []
        if bracketPos == -1:            
            return Node(int(data), children)            
        
        val = data[:bracketPos]              
        startIdx = bracketPos +1
        idx = startIdx
        bracketNum = 0
       
        while idx < len(data):
            if ((data[idx] == ',' or data[idx]==']') and bracketNum == 0):
                children.append(self.deserialize(data[startIdx:idx]))
                startIdx = idx+1
            if data[idx] == '[':
                bracketNum += 1
            elif data[idx] == ']':
                bracketNum -= 1
            idx += 1
        return Node(int(val), children)
                
                
            
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))