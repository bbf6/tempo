import TimeSignature from 'src/interfaces/time.signature';

const data:TimeSignature[] = [
  { label: '2/4',   beats: [true, false] },
  { label: '3/4',   beats: [true, false, false] },
  { label: '4/4',   beats: [true, false, false, false] },
  { label: '2/2',   beats: [true, false] },
  { label: '6/8',   beats: [true, false, false, true, false, false] },
  { label: '9/8',   beats: [true, false, false, true, false, false, true, false, false] },
  { label: '12/8',  beats: [true, false, false, true, false, false, true, false, false, true, false, false] },
  { label: '5/4',   beats: [true, false, false, false, false] },
  { label: '7/8',   beats: [true, false, false, true, false, false, false] },
  { label: '5/8',   beats: [true, false, false, false, false] },
  { label: '7/4',   beats: [true, false, false, false, false, false, false] },
  { label: '3/8',   beats: [true, false, false] },
  { label: '4/8',   beats: [true, false, false, false] },
  { label: '8/8',   beats: [true, false, false, false, false, false, false, false] },
  { label: '11/8',  beats: [true, false, false, true, false, false, true, false, false, false, false] },
  { label: '13/8',  beats: [true, false, false, true, false, false, true, false, false, true, false, false, false] },
  { label: '15/16', beats: [true, false, false, true, false, false, true, false, false, true, false, false, false, false, false] }
];

export default data;
