# *-* coding:utf-8 *-*

"""
文件中各行已经根据时间排序
使用堆，返回出现次数前7的时间点
"""

class RecordHeap(object):
    """保存Record的list，同时保证list具备堆得性质，index为0的元素不使用"""
    def __init__(self, max_capacity):
        self.result = ["None"]
        self.max_capacity = max_capacity

    def add_record(self, record):
        """add a new record to heap"""
        if len(self.result) < self.max_capacity + 1:
            self.result.append(record)
            self.sift_up()
        else:
            # compare the reocrd's count with the item[1]'s count. if bigger, the replace
            self.result[1] = record
            self.sift_down()

    def sift_down(self):
        """heap sift down"""
        heap_length = len(self.result)
        index = 1
        while index * 2 < heap_length:
            child_index = index * 2
            if child_index + 1 < heap_length:
                if self.result[child_index].compare_count(self.result[child_index + 1]) > 0:
                    child_index += 1

            if self.result[index].compare_count(self.result[child_index]) > 0:
                tmp = self.result[index]
                self.result[index] = self.result[child_index]
                self.result[child_index] = tmp
                index = child_index
            else:
                break


    def sift_up(self):
        """heap sift up"""
        index = len(self.result) - 1
        while index > 1:
            if self.result[index].compare_count(self.result[index/2]) < 0:
                tmp = self.result[index]
                self.result[index] = self.result[index/2]
                self.result[index / 2] = tmp
                index = index / 2
            else:
                break
        return

    def print_result(self):
        for index in range(1, len(self.result)):
            print self.result[index]




class Record(object):
    """Record of time and count"""
    def __init__(self, time):
        self.time = time
        self.count = 1

    def same_time(self, time):
        """judeg time is the same"""
        return self.time == time

    def count_plus_one(self):
        """count increase"""
        self.count += 1

    def compare_count(self, record):
        """compare two item's count"""
        return self.count - record.count

    def __str__(self):
        return 'time is {0}, count is {1}'.format(self.time, self.count)


if __name__ == "__main__":
    record_heap = RecordHeap(7)

    fp_in = open("trade.log", 'r')

    # read first line
    first_line = fp_in.readline()
    current_time = first_line.split(",")[0]
    current_record = Record(current_time)

    for eachline in fp_in:
        next_time = eachline.split(",")[0]
        if current_record.same_time(next_time):
            current_record.count_plus_one()
        else:
            record_heap.add_record(current_record)
            current_record = Record(next_time)

    record_heap.add_record(current_record)
    record_heap.print_result()
